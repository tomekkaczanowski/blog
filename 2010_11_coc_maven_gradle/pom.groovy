project {
  modelVersion '4.0.0'
  artifactId 'coc-comparison'
  groupId 'grId'
  version '1.0-SNAPSHOT'

  dependencies {
    dependency('commons-lang:commons-lang:2.5')
    dependency('junit:junit:4.8.2')
  }

  build {
    plugins {
      plugin {
        groupId 'org.apache.maven.plugins'
        artifactId 'maven-compiler-plugin'
        configuration {
          source '1.5'
          target '1.5'
        }
      }
    }
  }
}
