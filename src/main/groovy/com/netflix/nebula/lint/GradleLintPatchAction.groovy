            def patch = patch(violations*.fixes.flatten() as List<GradleLintFix>)
            w.write(patch)
        return mode == Symlink ? [readSymbolicLink(file.toPath()).toString()] :
                // careful, because file.readLines() strips carriage returns
                file.text.isEmpty() ? [] : file.text.split('\n').toList()