#!/bin/bash
find . -type f -name ".classpath" | xargs rm -f
find . -type f -name ".project" | xargs rm -f
find . -type f -name ".factorypath" | xargs rm -f
find . -type d -name ".apt_generated" | xargs rm -fr
find . -type d -name ".settings" | xargs rm -fr
find . -type d -name "target" | xargs rm -fr
