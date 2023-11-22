setup:
	gradle wrapper --gradle-version 8.2

clean:
	gradle clean

build:
	gradle clean build

start:
	gradle bootRun

install:
	gradle installDist

start-dist:
	./build/install/app/bin/app

lint:
	gradle checkstyleMain checkstyleTest

test:
	gradle test

report:
	gradle jacocoTestReport

.PHONY: build
