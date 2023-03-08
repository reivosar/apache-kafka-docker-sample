@echo off
echo build-jar start
call build-jar.bat
echo build-jar end

echo build-docker start
call build-docker.bat
echo build-docker end
