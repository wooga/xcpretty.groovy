/*
 * Copyright 2020 Wooga GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.wooga.xcodebuild.xcpretty

import spock.lang.Specification

class SnippetSpec extends Specification {

    String getPath(String path, Integer line) {
        def resourcePath = SnippetSpec.class.getResource(path).path
        "${resourcePath}:${line}"
    }

    def "gets the snippet out of the file path"() {
        given:
        def path = getPath("/fixtures/NSStringTests.m", 36)

        expect:
        Snippet.fromFile(path).contents ==
                """    it(@"-split: splits with delimiter string, not just a char", ^{\n""" +
                """        [[[@"one / two / three" split:@" / "] should] equal:@[@"one", @"two", @"three"]];\n""" +
                """    });\n"""
    }

    def 'saves the file path'() {
        given:
        def path = getPath("/fixtures/NSStringTests.m", 36)

        expect:
        Snippet.fromFile(path).filePath == path
    }

    def "doesn't crash when there's nothing to read"() {
        given:
        def path = getPath("/fixtures/NSStringTests.m", 64)

        expect:
        Snippet.fromFile(path).contents == "\nSPEC_END\n"
    }

    def "doesn't crash if file path is invalid"() {
        expect:
        Snippet.fromFile('invalid-path').contents == ""
    }

    def "doesn't crash if a failure is on the first line"() {
        given:
        def path = getPath("/fixtures/NSStringTests.m", 0)

        expect:
        Snippet.fromFile(path).contents == "//\n//  NSStringTests.m\n//  SampleProject\n"
    }

    def "doesn't crash if the file has only 1 line"() {
        given:
        def path = getPath("/fixtures/oneliner.m", 0)

        expect:
        Snippet.fromFile(path).contents == "[[[@1 should] equal] @3];\n"
    }

}
