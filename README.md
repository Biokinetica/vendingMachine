# vendingMachine
##Build and Run
To build the code, we use Gradle in the directory vendingMachine:
`gradle build`
Before we run, we must install using:
`gradle install`
And findally:
`.\build\install\vendingMachine\bin\vendingMachine.bat`
The above line calls a batch file for windows, so do run this on windows from the command line. CMD prompt or powershell works fine.
##Testing
Just input:
`gradle clean test`
Alternatively, you can view the idex.html in `\build\reports\tests\test` in your webbrowser.