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

import com.wooga.xcodebuild.xcpretty.formatters.Formatter
import spock.lang.Specification

class PrinterSpec extends Specification {

    Writer outputWriter = new StringWriter()
    Printer printer = new Printer(new DummyFormatter(), outputWriter)


    def "prints value to provided writer"() {
        when:
        printer.println("hey ho let's go")

        then:
        outputWriter.toString() == "hey ho let's go\n"
    }

    def "doesn't print empty lines"() {
        when:
        printer.println("hey ho let's go")
        printer.println("")
        printer.println("hey ho let's go")

        then:
        outputWriter.toString() == "hey ho let's go\nhey ho let's go\n"
    }

    class DummyFormatter extends Formatter {
        @Override
        String prettyFormat(String line) {
            return line
        }

        @Override
        String formatAnalyze(String fileName, String filePath) {
            return null
        }

        @Override
        String formatBuildTarget(String target, String project, String configuration) {
            return null
        }

        @Override
        String formatAggregateTarget(String target, Object project, String configuration) {
            return null
        }

        @Override
        String formatAnalyzeTarget(String target, Object project, String configuration) {
            return null
        }

        @Override
        String formatCheckDependencies() {
            return null
        }

        @Override
        String formatClean(String project, String target, String configuration) {
            return null
        }

        @Override
        String formatCleanTarget(String target, String project, String configuration) {
            return null
        }

        @Override
        String formatCleanRemove() {
            return null
        }

        @Override
        String formatCompile(String fileName, String filePath) {
            return null
        }

        @Override
        String formatCompileCommand(String compilerCommand, String filePath) {
            return null
        }

        @Override
        String formatCompileStoryboard(String fileName, String filePath) {
            return null
        }

        @Override
        String formatCompileXib(String fileName, String filePath) {
            return null
        }

        @Override
        String formatCopyHeaderFile(String source, String target) {
            return null
        }

        @Override
        String formatCopyPlistFile(String source, String target) {
            return null
        }

        @Override
        String formatCopyStringsFile(String fileName) {
            return null
        }

        @Override
        String formatCpresource(String file) {
            return null
        }

        @Override
        String formatGenerateDsym(String dsym) {
            return null
        }

        @Override
        String formatLinking(String file, String buildVariant, String arch) {
            return null
        }

        @Override
        String formatLibtool(String library) {
            return null
        }

        @Override
        String formatPassingTest(String suite, String test, String time) {
            return null
        }

        @Override
        String formatPendingTest(String suite, String test) {
            return null
        }

        @Override
        String formatMeasuringTest(String suite, String test, String time) {
            return null
        }

        @Override
        String formatFailingTest(String suite, String test, String reason, String filePath) {
            return null
        }

        @Override
        String formatProcessPch(String file) {
            return null
        }

        @Override
        String formatProcessPchCommand(String filePath) {
            return null
        }

        @Override
        String formatPhaseSuccess(String phaseName) {
            return null
        }

        @Override
        String formatPhaseScriptExecution(String scriptName) {
            return null
        }

        @Override
        String formatProcessInfoPlist(String fileName, String filePath) {
            return null
        }

        @Override
        String formatCodesign(String file) {
            return null
        }

        @Override
        String formatPreprocess(String file) {
            return null
        }

        @Override
        String formatPbxcp(String file) {
            return null
        }

        @Override
        String formatShellCommand(String command, String arguments) {
            return null
        }

        @Override
        String formatTestRunStarted(String name) {
            return null
        }

        @Override
        String formatTestRunFinished(String name, String time) {
            return null
        }

        @Override
        String formatTestSuiteStarted(String name) {
            return null
        }

        @Override
        String formatTouch(String filePath, String fileName) {
            return null
        }

        @Override
        String formatTiffutil(String file) {
            return null
        }

        @Override
        String formatWriteFile(String file) {
            return null
        }

        @Override
        String formatWriteAuxiliaryFiles() {
            return null
        }
    }
}
