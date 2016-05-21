<?php
	// require "/var/www/html/Hackathon/ProcurarBancoDados.php";
	
	
	// $senha = $_GET['senha'];
	// $enderecoEmail = $_GET['enderecoEmail'];
	
	require "/home/u569143437/public_html/Hackathon/ProcurarBancoDados.php";

	$enderecoEmail = $_POST['enderecoEmail'];
	$senha = $_POST['senha'];
	$tamanho = 22;

	$existe = ExisteUsuario('Usuario', 'salt', 'enderecoEmail', $enderecoEmail);	
	
	if ($existe < 0){
		echo "	-1";
	}
	else{
		$salt = substr(sha1(mt_rand()), 0, $tamanho);
		$senha = md5($senha.$salt);
		InserirDados($salt, $enderecoEmail, $senha);
		echo "1";
	}
?>
