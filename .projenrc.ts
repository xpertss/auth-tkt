import { JavaLibraryProject } from '@xpertss/projen-types';

const project = new JavaLibraryProject({
  name: 'auth-tkt',
  groupId: 'org.xpertss',
  artifactId: 'auth-tkt',          // must match Central exactly
  version: '3.0.0',                // D1; only the release:version baseline (repo already has v-tags)
  description: 'Servlet Filter that implements the ModAuthTkt functionality in Java',
  url: 'https://github.com/xpertss/auth-tkt',  // pom <scm> is derived from this
  developers: [
    { name: 'Chris Floersch', url: 'https://github.com/cfloersch', organization: 'Xpert Solution Services' },
  ],
  javaVersion: '21',
  minMajorVersion: 3,              // floors any future computed release at 3.0.0
  license: 'MIT',                  // D2: projen generates the MIT LICENSE (owner: projen default)
  copyrightPeriod: '2018-2026',    // D2b
  publishCodeIndex: false,         // D4
});

project.addGitIgnore('*.iml');     // legacy .gitignore line the generated one drops

// The generated pom replaces pom.xml entirely: carry the legacy compile deps over.
// Spec syntax is groupId/artifactId@version (not group:artifact:version).
project.pom.addDependency('org.xpertss/stdlib@1.1.0');
project.pom.addDependency('org.xpertss/proximo@1.0');                 // used by AuthTicketFilter (main code)
project.pom.addDependency('javax.servlet/servlet-api@2.5', 'provided');

// Tests (F030): JUnit 5 comes with the generated pom. Mockito 5 is used through its static API
// (mock/when/verify), not the JUnit extension, so mockito-core alone is enough.
project.pom.addTestDependency('org.mockito/mockito-core@5.24.0');

// Mockito 5 mocks through its inline agent. Without this, the JVM loads the agent dynamically and warns
// (and a future JDK will refuse). maven-dependency-plugin's `properties` goal publishes the jar path of
// every dependency as ${group:artifact:jar}; surefire then starts the JVM with Mockito as a javaagent.
project.pom.addPlugin('org.apache.maven.plugins/maven-dependency-plugin@3.11.0', {
  executions: [{ id: 'mockito-agent-path', goals: ['properties'] }],
});
project.pom.addPlugin('org.apache.maven.plugins/maven-surefire-plugin@3.6.0', {
  configuration: { argLine: '-javaagent:${org.mockito:mockito-core:jar}' },
});

project.synth();
