.DEFAULT_GOAL := build-run

setup:
	gradle wrapper --gradle-version 8.3

clean:
	./gradlew clean

build:
	./gradlew clean build

install:
	./gradlew clean install

run-dist:
	./build/install/app/bin/app

run:
	./gradlew run

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain

check-deps:
	./gradlew dependencyUpdates -Drevision=release

update-deps:
	./gradlew useLatestVersions

build-run: build run

.PHONY: build