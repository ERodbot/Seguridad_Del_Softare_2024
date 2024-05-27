
Instituto Tecnológico de Costa Rica 
Seguridad del Software
Proyecto #2 
#### Reto: caas  



<!DOCTYPE html>
<html>
<head>
<style>
  body {
    margin: 20px 
  }
  .box {
    border: 1px solid #000;
    padding: 10px;
    margin: 0px 5px 0px 5px;
  }
  .header {
    font-weight: bold;
    color: #FFFFF;
  }
  .content {
    color: #0000FF;
  }
  .img {
    margin: 20px 0px 20px 0px
    px;
  }

</style>
</head>
<body>



<div></div>
<div class="box">
  <div class="header">Responsable:</div>
  <div class="content">
    <p>Esteban Leiva Montenegro</p>
  </div>
</div>

<div class="box">
  <div class="header">Puntos:</div>
  <div class="content">
    <p>150</p>
  </div>
</div>

<div class="box">
  <div class="header">Categoría:</div>
  <div class="content">
    <p>Web exploitation</p>
  </div>
</div>

<div class="box">
  <div class="header">Empezado:</div>
  <div class="content">
    <p>6/05/2024</p>
  </div>
</div>


<div class="box">
  <div class="header">Terminado:</div>
  <div class="content">
    <p>6/05/2024</p>
  </div>
</div>

<div class="box">
  <div class="header">Procedimiento</div>
  <div class="content">
      <p>Primeramente accedemos al código del reto, donde podemos encontrar que se utiliza la función exec con un parámetro entrada del usuario en la url representado por "${req.params.message}"</p>
      <img src= "images\img_caas_1.png" class="img"/>
      <p>Luego se accede a la página, donde se explora la dinámica de "Cowsay" por medio de entrada de parámetros en la URL.</p>
      <img src= "images\img_caas_2.png" class="img"/>
      <p>Se realiza una inyección de comandos donde se pasa como parámetro un comando '| ls -la' que nos muestra los archivos desde el lado del servidor, entre los cuales se encuentra "falg.txt", pues el caracter "|" nos hace un pipeline que permite concatenar varios comandos, otra opción sería usar el comando  ";" </p>
      <img src= "images\img_caas_3.png" class="inimg"/>
      <p>Seguidamente, se inyecta el comando
      "; cat flag.txt" para poder desplegar en la página el contendio de "falg.txt" </p>
      <img src= "images\img_caas_4.png" class="inimg"/>
      <p>Se introduce el flag dentro de la página de picoCTF y se obtiene el puntaje</p>
      <img src= "images\img_caas_5.png" class="inimg"/>

  </div>
</div>

<div class="box">
  <div class="header">Herramientas utilizadas</div>
  <div class="content">
    <p>Browser: Firefox </p>
  </div>
</div>

<div class="box">
  <div class="header">CWE del reto:</div>
  <div class="content">
    <p>		
    CWE-20: Improper Input Validation
    </p>
    <p>
    The product receives input or data, but it does not validate or incorrectly validates that the input has the properties that are required to process the data safely and correctly.</p>
  </div>
</div>

<div class="box">
  <div class="header">Patrón CAPEC utilizado:</div>
  <div class="content">
    <p>CAPEC-88: OS Command Injection</p>
    <p>In this type of an attack, an adversary injects operating system commands into existing application functions. An application that uses untrusted input to build command strings is vulnerable. An adversary can leverage OS command injection in an application to elevate privileges, execute arbitrary commands and compromise the underlying operating system.</p>
  </div>
</div>

<div class="box">
  <div class="header">Bandera</div>
  <div class="content">
    <p>picoCTF{moooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo0o}</p>
  </div>
</div>

</body>
</html>
