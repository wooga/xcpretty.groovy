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

class Snippet {

    final String contents
    final String filePath

    Snippet(String contents, String filePath) {
        this.contents = contents
        this.filePath = filePath
    }

    static fromFile(String filePath) {
        try {
            def pathLine = filePath.split(':')
            def text = readSnippet(new File(pathLine[0]), Integer.parseInt(pathLine[1]))
            return new Snippet(text, filePath)
        } catch (ignored) {
            return new Snippet("", filePath)
        }
    }

    static readSnippet(File file, int aroundLine) {
        def text = ""
        def startingPostion = aroundLine - 2
        file.withReader { reader ->
            startingPostion.times {
                reader.readLine()
            }
            def lines = []
            3.times {
                lines << reader.readLine()
            }
            text += lines.findAll { it != null }.join("\n")
        }
        text + "\n"
    }
}
