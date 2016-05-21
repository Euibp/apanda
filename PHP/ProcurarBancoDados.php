<?php
 	

	 	function ExisteUsuario($tabela, $selecionado,$seletor,$conteudoSeletor)
	 	{
	 	// 	$bancoDados = 'ufrj';
			// $password = 'password';
			// $root = 'root';
			// $host = 'localhost';

			$bancoDados = 'u569143437_ufrj';
			$password = 'password';
			$root = 'u569143437_root';
			$host = 'mysql.hostinger.com.br';

	 		$con = mysqli_connect($host, $root, $password) or die ('N&atilde;o foi poss&iacute;vel conectar: '.mysqli_connect_errno()."\n");
	 		$db = mysqli_select_db($con,$bancoDados);
	 		$query = "SELECT " . $selecionado . " FROM ".$tabela . " WHERE " .  $seletor . " = " . "'" .$conteudoSeletor. "'";;
	 		$resultado = mysqli_query($con, $query) or die.('N&atilde;o foi poss&iacute;vel conectar: '.mysqli_error($con)."\n");
	 		$row = mysqli_fetch_array($resultado);
			mysqli_close($con);
	 		
	 		if (is_null($row[0])){
	 			return 1;
	 		}
	 		else {
	 		 	return -1;
	 		}
	 	}

	 	function ProcurarDados($tabela, $selecionado,$seletor,$conteudoSeletor)
	 	{
 		// 	$bancoDados = 'ufrj';
			// $password = 'password';
			// $root = 'root';
			// $host = 'localhost';

			$bancoDados = 'u569143437_ufrj';
			$password = 'password';
			$root = 'u569143437_root';
			$host = 'mysql.hostinger.com.br';

	 		$con = mysqli_connect($host, $root, $password) or die ('N&acute;o foi poss&itilde;vel conectar: '.mysqli_connect_errno());
	 		$db = mysqli_select_db($con, $bancoDados);
	 		$query = "SELECT ". $selecionado . " FROM " . $tabela . " WHERE " . $seletor ." = '". $conteudoSeletor . "'";
	 		$resultado = mysqli_query($con, $query) or die('N´o foi poss$itilde;vel conectar: '.mysqli_connect_errno());
	 		$row = mysqli_fetch_array($resultado);
	 		$linhas = mysqli_num_rows($resultado);
	 		mysqli_close($con);
	 		return $row;
		 }

		 function InserirDados($salt, $enderecoEmail, $senha){

			// $bancoDados = 'ufrj';
	 	// 	$password = 'password';
			// $host = 'localhost';
			// $root = 'root';
			
			$bancoDados = 'u569143437_ufrj';
  			$password = 'password';
  			$root = 'u569143437_root';
 			$host = 'mysql.hostinger.com.br';

			$con = mysqli_connect($host, $root, $password) or die ('N&acute;o foi poss&itilde;vel conectar: '.mysqli_connect_errno());
			$db = mysqli_select_db($con, $bancoDados);
			$query = "INSERT INTO `Usuario` (`enderecoEmail`, `senha`, `salt`) values ('$enderecoEmail','$senha','$salt')";
			$resultado = mysqli_query($con, $query) or die('N&atilde;o foi poss&iacute;vel conectar: '.mysqli_error($con));
			mysqli_close($con);
		}
?>