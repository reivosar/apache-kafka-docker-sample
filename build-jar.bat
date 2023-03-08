@echo off
setlocal enabledelayedexpansion

:main
	cd %~dp0
    pushd %~dp0

    ./gradlew bootJar

    popd
exit /b