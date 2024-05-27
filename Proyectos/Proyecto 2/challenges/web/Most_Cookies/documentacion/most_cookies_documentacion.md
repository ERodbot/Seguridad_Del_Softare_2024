
Instituto Tecnológico de Costa Rica 
Seguridad del Software
Proyecto #2 
#### Reto: Most Cookies



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
      <p>Primeramente se inspecciona el archivo server.py, el cual contiene una configuración de una página web por medio de flask, donde se observa que la variable  'secret key' se obtiene de una lista de posibles valores </p>
      <img src= "imagenes\img_most_cookies_1.png" class="img"/>
      <p>Además se observó que el flujo de la aplicación es el siguiente: </p>
      <img src= "imagenes\img_most_cookies_2.png" class="img"/>
      <p>La aplicación carga la página principal, donde se pide un nombre que se busca dentro de la lista de 'cookie_names', si existe entonces se crea una sesión donde el valor de 'very_auth' es el nombre ingresado. Aquí se señala que como los valores de la llave para encriptar dicha llave son limitados, se podría tratar de usar fuerza bruta más adelante.</p>
      <img src= "imagenes\img_most_cookies_3.png" class="img"/>
      <p>En esta parte se carga condicionalmente el html 'flag.html' si el valor 'very_auth' de la aplicación corresponde a 'admin'. Entonces se asume que se debe lograr modificar o acceder a la ruta '/display' con una cookie cuyo valor 'very_auth' corresponda a 'admin'</p>
      <p>Con una búsqueda en google se encontró una biblioteca en python que codifica sesiones de cookies para flask (Bingo!). </p>
      <img src= "imagenes\img_most_cookies_4.png" class="img"/>
      <p>Se extrae la función encode de la bilbioteca y se crea una función donde se prueba cada una de las posibles llaves de encriptción antes mencionadas, con el formato de cookie {"very_auth" : "admin}. Esta conclusión se obtuvo de utilizar la herramienta cyberchef para desencriptar el cuerpo del cookie, el cual se encontraba en base64 </p>
      <img src= "imagenes\img_most_cookies_5.png" class="img"/>  
      <p>En la imagen de arriba se logra apreciar como al inspeccionar la página se puede obtener el valor de la sesión actual</p>
      <p>Por medio de cyberchef observamos el patrón del cuerpo del cookie antes mencionado</p>
      <img src= "imagenes\img_most_cookies_6.png" class="img"/>  
      <p>El código del exploit se presenta en la siguiente imagen. Como se puede observar, se utiliza la biblioteca  'requests' para conectarse a la ruta del API con la credencial creada por cada posible llave y donde se encuentra el texto de la bandera se imprime 'flag.html' y se retorna.
      <img src= "imagenes\img_most_cookies_7.png" class="img"/> 
      </p>

     

      
      

  </div>
</div>

<div class="box">
  <div class="header">Herramientas utilizadas</div>
  <div class="content">
    <p>1. Python3</p>
    <p>2. Extracto de biblioteca 'flask-session-cookie-manager':
    https://github.com/noraj/flask-session-cookie-manager</p>
    <p>3. Biblioteca 'session'</p>
    <p>4. Cyberchef</p>
  </div>
</div>

<div class="box">
  <div class="header">CWE del reto:</div>
  <div class="content">
    <p>CWE-287: Improper Authentication</p>
    <p>When an actor claims to have a given identity, the product does not prove or insufficiently proves that the claim is correct.</p>
  </div>
</div>

<div class="box">
  <div class="header">Patrón CAPEC utilizado:</div>
  <div class="content">
    <p>CAPEC-114: Authentication Abuse</p>
    <p>An attacker obtains unauthorized access to an application, service or device either through knowledge of the inherent weaknesses of an authentication mechanism, or by exploiting a flaw in the authentication scheme's implementation. In such an attack an authentication mechanism is functioning but a carefully controlled sequence of events causes the mechanism to grant access to the attacker.</p>
  </div>
</div>

<div class="box">
  <div class="header">Bandera</div>
  <div class="content">
    <p>picoCTF{pwn_4ll_th3_cook1E5_743c20eb}</p>
  </div>
</div>

</body>
</html>
