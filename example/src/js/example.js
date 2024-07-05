import { Example } from 'capacitor-plugin-example';

window.testEcho = () => {
    const inputValue = document.getElementById("echoInput").value;
    Example.echo({ value: inputValue })
}
