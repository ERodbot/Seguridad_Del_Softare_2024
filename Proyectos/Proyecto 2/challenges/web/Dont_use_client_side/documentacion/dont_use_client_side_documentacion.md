Instituto Tecnológico de Costa Rica 
Seguridad del Software
Proyecto #2 
#### Reto: Dont use client side



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
    <p>Emanuel Rodríguez Oviedo</p>
  </div>
</div>

<div class="box">
  <div class="header">Puntos:</div>
  <div class="content">
    <p>100</p>
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
    <p>18/05/2024</p>
  </div>
</div>


<div class="box">
  <div class="header">Terminado:</div>
  <div class="content">
    <p>18/05/2024</p>
  </div>
</div>

<div class="box">
  <div class="header">Procedimiento</div>
  <div class="content">
      <p>Primero se accede al link presentado por el reto: <a href= "https://jupiter.challenges.picoctf.org/problem/17682"></a> https://jupiter.challenges.picoctf.org/problem/17682</p> 
      <p>Lo cual  despliega el siguiente sitio, donde se pude observar sistema de login</p>
      <img src= "imagenes\img_dont_use_client_side_1.png" class="img"/>
      <p> Se asume que se debe inspeccionar el contenido de la página gracias al nombre del reto, donde se utiliza la opción de 'click-derecho' 'inpseccionar' y se accede a la pestaña de 'Debugger' y se expanden los directorios hasta encontrar el archivo 'index'</p>
      <img src= "imagenes\img_dont_use_client_side_2.png" class="img"/>
      <img src= "imagenes\img_dont_use_client_side_3.png" class="img"/>
      <p>Aquí es obervable que exite una función para validar la contraseña, la cual está sin encriptar y se presenta desde el lado del cliente. Se utiliza el contenido de la misma para extraer el flag que a su vez representa la contraseña.</p>
      <p>En este caso la función solamente extrae por medio de splits pedazos del flag, que se reordenan tomando en cuenta el índice en que empieza el split y termina por cada comprobación, para formar el flag: 'picoCTF{no_clients_plz_b706c5}'</p>

  </div>
</div>

<div class="box">
  <div class="header">Herramientas utilizadas</div>
  <div class="content">
    <p>Firefox Developer Tools</p>
  </div>
</div>

<div class="box">
  <div class="header">CWE del reto:</div>
  <div class="content">
    <p>CWE-603: Use of Client-Side Authentication:</p>
    <p>A client/server product performs authentication within client code but not in server code, allowing server-side authentication to be bypassed via a modified client that omits the authentication check.</p>
  </div>
</div>

<div class="box">
  <div class="header">Patrón CAPEC utilizado:</div>
  <div class="content">
    <p>		CAPEC-114: Authentication Abuse</p>
    <p>An attacker obtains unauthorized access to an application, service or device either through knowledge of the inherent weaknesses of an authentication mechanism, or by exploiting a flaw in the authentication scheme's implementation. In such an attack an authentication mechanism is functioning but a carefully controlled sequence of events causes the mechanism to grant access to the attacker.</p>
  </div>
</div>

<div class="box">
  <div class="header">Bandera</div>
  <div class="content">
    <p>picoCTF{no_clients_plz_b706c5}</p>
  </div>
</div>

</body>
</html>
