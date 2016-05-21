<?php
	
	// require "/var/www/html/Hackathon/ProcurarBancoDados.php";

	
	// $enderecoEmail = $_GET['enderecoEmail'];
	// $senha = $_GET['senha'];

	require "/home/u569143437/public_html/Hackathon/ProcurarBancoDados.php";

	$enderecoEmail = $_POST['enderecoEmail'];
	$senha = $_POST['senha'];

	$existe = ExisteUsuario('Usuario', 'salt', 'enderecoEmail', $enderecoEmail);	

	 if ($existe > 0){
	 	echo "-1";
	 }
	 else {
	
	 	$salt = ProcurarDados('Usuario', 'salt','enderecoEmail', $enderecoEmail)[0];
		$confereSenha = ProcurarDados('Usuario', 'senha','enderecoEmail', $enderecoEmail)[0];
		$senha = md5($senha.$salt);
		if ($confereSenha == $senha)
			echo "2";
		else
			echo "-2";
	}


?>
