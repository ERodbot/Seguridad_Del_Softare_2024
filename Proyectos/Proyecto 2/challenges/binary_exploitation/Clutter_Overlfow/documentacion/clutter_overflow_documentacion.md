
Instituto Tecnológico de Costa Rica 
Seguridad del Software
Proyecto #2 
#### Reto: Clutter Overflow



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
    <p>Binary Exploitation</p>
  </div>
</div>

<div class="box">
  <div class="header">Empezado:</div>
  <div class="content">
    <p>15/05/2024</p>
  </div>
</div>


<div class="box">
  <div class="header">Terminado:</div>
  <div class="content">
    <p>16/05/2024</p>
  </div>
</div>

<div class="box">
  <div class="header">Procedimiento</div>
  <div class="content">
      <p>El desafío presenta una apliciación que recive la entrada de un usuario por consola y luego condicionalmente retorna la bandera si una posición de memoria fue sobreescrita a '0xdeadbeef' o sino explica que no se llegó al código deseado</p>
      <p>Debido al reto presentado y al uso de la función gets, que copia a un buffer de 100 caracteres la entrada del usuario, se asume que se debe realizar un buffer overflow. Como se puede ver, la variable a comparar para obtener el flag se declara antes que el buffer</p>
      <img src= "images\img_clutter_overflow_1.png" class="img"/>
      <p>Por lo tanto se asume que estará en una posición más alta en la pila. Esto debido a que el archivo es de tipo ELF-64 bits en arquitectura intel x86</p>
      <img src= "images\img_clutter_overflow_2.png" class="img"/>
      <p>Para poder conocer el tamaño que debemos utilizar como relleno hasta poder sobreescribir la variable 'GOAL' se revisa el código ensamblador desensamblado, al ejecutar gdb en el archivo fuente provisto 'Chall'</p>
      <img src= "images\img_clutter_overflow_3.png" class="img"/>
      <img src= "images\img_clutter_overflow_4.png" class="img"/>
      <p>En la memoria *main+4 se reservan 272 bytes para las variables de la aplicación, además en la memoria *main+138 vemos que después de la llamada a gets se mueve el valor hexadecimal '0xdeadbeef' a eax, luego se compara el registro '%rax' con la base de la pila movida 8 bytes hacia abajo, donde se intuye que debe estar el valor de GOAL, para finalmente comprararlos y si son iguales imprimir la bandera.</p>
      <p>A partir de esto podemos asumir que debemos llenar 264 bytes de caracteres basura y los ultimos 9 deben colocarse en memoria tal que se lean como 0xdeadbeef</p>
      <p>Para ello se utiliza la biblioteca pwntools, donde se crea un script que genera un payload con basura y se le concatena la cadena hexadecimal meta</p>
      <img src= "images\img_clutter_overflow_5.png" class="img"/>
      <p>Después se ejecutó el script y se obtuvo la flag</p>
      <img src= "images\img_clutter_overflow_6.png" class="img"/>


      
      

  </div>
</div>

<div class="box">
  <div class="header">Herramientas utilizadas</div>
  <div class="content">
    <p>1. GNU Debugger</p>
    <p>2. python3</p>
    <p>3. Biblioteca Pwntools</p>
  </div>
</div>

<div class="box">
  <div class="header">CWE del reto:</div>
  <div class="content">
    <p>CWE-120: Buffer Copy without Checking Size of Input ('Classic Buffer Overflow')</p>
    <p>The product copies an input buffer to an output buffer without verifying that the size of the input buffer is less than the size of the output buffer, leading to a buffer overflow.</p>
  </div>
</div>

<div class="box">
  <div class="header">Patrón CAPEC utilizado:</div>
  <div class="content">
    <p>CAPEC-100: Overflow Buffers</p>
    <p>Buffer Overflow attacks target improper or missing bounds checking on buffer operations, typically triggered by input injected by an adversary. As a consequence, an adversary is able to write past the boundaries of allocated buffer regions in memory, causing a program crash or potentially redirection of execution as per the adversaries' choice.</p>
  </div>
</div>

<div class="box">
  <div class="header">Bandera</div>
  <div class="content">
    <p>picoCTF{c0ntr0ll3d_clutt3r_1n_my_buff3r}</p>
  </div>
</div>
</body>
</html>
