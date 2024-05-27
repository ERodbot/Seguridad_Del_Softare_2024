Instituto Tecnológico de Costa Rica 
Seguridad del Software
Proyecto #2 
#### Reto: Unpackme.py



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
    <p>100</p>
  </div>
</div>

<div class="box">
  <div class="header">Categoría:</div>
  <div class="content">
    <p>Reverse Engineering</p>
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
      <p>Primero se abre el código de python, donde se observa que por medio de la biblioteca de Fernet se desencripta un string encriptado en base 64 para ejecutarlo por medio de la directiva exec</p>
      <img src= "images\img_unpackme_1.png" class="img"/>
      <p>Se decide imprimir el código para poder observar qué es lo que realiza el string</p>
      <img src= "images\img_unpackme_2.png" class="img"/>
      <p>Aquí se observa una ejecución condicional, donde se dá un check de la contraseña proporcionada como entrada del usuario en consola en contraste con el "batteryhorse", al tenerlo directamente en el código se logra copiar y se retorna como resultado el flag</p>
      <img src= "images\img_unpackme_3.png" class="img"/>

  </div>
</div>

<div class="box">
  <div class="header">Herramientas utilizadas</div>
  <div class="content">
    <p>www.base64decode.org</p>
  </div>
</div>

<div class="box">
  <div class="header">CWE del reto:</div>
  <div class="content">
    <p>CWE-327: Use of a Broken or Risky Cryptographic Algorithm</p>
    <p>Cryptographic algorithms are the methods by which data is scrambled to prevent observation or influence by unauthorized actors. Insecure cryptography can be exploited to expose sensitive information, modify data in unexpected ways, spoof identities of other users or devices, or other impacts.

It is very difficult to produce a secure algorithm, and even high-profile algorithms by accomplished cryptographic experts have been broken. Well-known techniques exist to break or weaken various kinds of cryptography. Accordingly, there are a small number of well-understood and heavily studied algorithms that should be used by most products. Using a non-standard or known-insecure algorithm is dangerous because a determined adversary may be able to break the algorithm and compromise whatever data has been protected.

Since the state of cryptography advances so rapidly, it is common for an algorithm to be considered "unsafe" even if it was once thought to be strong. This can happen when new attacks are discovered, or if computing power increases so much that the cryptographic algorithm no longer provides the amount of protection that was originally thought.

For a number of reasons, this weakness is even more challenging to manage with hardware deployment of cryptographic algorithms as opposed to software implementation. First, if a flaw is discovered with hardware-implemented cryptography, the flaw cannot be fixed in most cases without a recall of the product, because hardware is not easily replaceable like software. Second, because the hardware product is expected to work for years, the adversary's computing power will only increase over time.</p>
  </div>
</div>

<div class="box">
  <div class="header">Patrón CAPEC utilizado:</div>
  <div class="content">
    <p>CAPEC-97: Cryptanalysis</p>
    <p>Cryptanalysis is a process of finding weaknesses in cryptographic algorithms and using these weaknesses to decipher the ciphertext without knowing the secret key (instance deduction). Sometimes the weakness is not in the cryptographic algorithm itself, but rather in how it is applied that makes cryptanalysis successful. An attacker may have other goals as well, such as: Total Break (finding the secret key), Global Deduction (finding a functionally equivalent algorithm for encryption and decryption that does not require knowledge of the secret key), Information Deduction (gaining some information about plaintexts or ciphertexts that was not previously known) and Distinguishing Algorithm (the attacker has the ability to distinguish the output of the encryption (ciphertext) from a random permutation of bits).</p>
  </div>
</div>

<div class="box">
  <div class="header">Bandera</div>
  <div class="content">
    <p>picoCTF{175_chr157m45_cd82f94c}</p>
  </div>
</div>

</body>
</html>
