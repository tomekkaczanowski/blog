project {
  modelVersion '4.0.0'
  artifactId 'coc-comparison'
  groupId 'grId'
  version '1.0-SNAPSHOT'

  dependencies {
    dependency('commons-lang:commons-lang:2.5')
    dependency('junit:junit:4.8.2')
  }
  
  properties {
    'maven.compiler.target' '1.6'
    'maven.compiler.source' '1.6'
  }
}
