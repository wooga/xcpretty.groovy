#!groovy
@Library('github.com/wooga/atlas-jenkins-pipeline@1.x') _

withCredentials([string(credentialsId: 'xcpretty_groovy_coveralls_token', variable: 'coveralls_token')]) {
    buildJavaLibrary plaforms: ['linux'], coverallsToken: coveralls_token
}
