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

package com.wooga.xcodebuild.xcpretty.formatters

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll


class ANSISpec extends Specification implements ANSI {
    @Shared
    def text = "This is the PARTY"

    def setup() {
        colorize = true
    }

    def "colors text red"() {
        expect:
        red(text) == "${new String((char) 27)}[31m${text}${new String((char) 27)}[0m"
    }

    def "formats text bold"() {
        expect:
        white(text) == "${new String((char) 27)}[39;1m${text}${new String((char) 27)}[0m"
    }

    def "colors text green"() {
        expect:
        green(text) == "${new String((char) 27)}[32;1m${text}${new String((char) 27)}[0m"
    }

    def "colors text cyan"() {
        expect:
        cyan(text) == "${new String((char) 27)}[36m${text}${new String((char) 27)}[0m"
    }

    def "colors text yellow"() {
        expect:
        yellow(text) == "${new String((char) 27)}[33m${text}${new String((char) 27)}[0m"
    }

    @Unroll
    def "returns uncolored text for method #method when colorize is false"() {
        given:
        def c = isColorize()
        colorize = false

        expect:
        this.invokeMethod(method, text) == text

        cleanup:
        colorize = c

        where:
        method   | _
        "yellow" | _
        "white"  | _
        "green"  | _
        "cyan"   | _
        "red"    | _
    }

    def "can mix random known colors"() {
        expect:
        ansiParse(text, Color.yellow, Effect.underline) == "${new String((char) 27)}[33;4m${text}${new String((char) 27)}[0m"
    }

}
