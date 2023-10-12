<h1>Java-Regional-Captcha</h1>
    
<ol>
    <h2><li>Description</li></h2>
    <p>This project consists of a Regional Captcha verification system in Hindi language, designed using Java Swing.</p>
    <h2><li>Setup</li></h2>
    <ul>
        <li>The program consists of a predefined array of string names in Hindi.</li>
        <li>When the program starts, a random string will be selected from the array and a distorted image will be displayed in the label field.</li>
    </ul>
    <h2><li>Usage</li></h2>
    <p>The user will have to input (type) the correct Hindi string name corresponding to the captcha label.</p>
    <h2><li>Captcha Pass Condition</li></h2>
    <p>If the user enters the same string (corresponding to the random string), then the verification is complete and the user can proceed to the next page.</p>
    <h2><li>Captcha Fail Condition</li></h2>
    <ul>
        <li>If the user enters the incorrect (different) string, then authentication will fail and user will have to try again.</li>
        <li>The refresh button allows the user to generate a new captcha string while simultaneously shuffling the options.</li>
    </ul>
    <h2><li>Steps for compiling and executing</li></h2>
    <ol>
        <li>Open the .java file (RegionalCaptcha.java) given in the zip file.</li>
        <li>If you are using VS code, then simply open the .java source file and run the program.</li>
        <li>
            If you wish to run the program using cmd, then
            <ol>
                <li>Navigate to the source folder using “cd FILE_LOCATION” command.</li>
                <li>Generate the bytecode (.class file) by using the “javac RegionalCaptcha.java” command.</li>
                <li>Execute the compiled bytecode by using the “java RegionalCaptcha” command.</li>
            </ol>
        </li>
        <li>On successful compilation and execution, the Swing application will display the frame along with the label, button controls contained inside of it.</li>
    </ol>
</ol>