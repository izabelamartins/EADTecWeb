<?php
require_once("seguranca.html");
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
  $usuario = (isset($_POST['usuario'])) ? $_POST['usuario'] : '';
  $senha = (isset($_POST['senha'])) ? $_POST['senha'] : '';
  
  if (validaUsuario($usuario, $senha) == true) {
    header("Location: index.html");
  } else {
    expulsaVisitante();
  }
}