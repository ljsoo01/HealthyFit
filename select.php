<?php
    $conn = mysqli_connect('127.0.0.1:3307', 'root', '', 'healthyfit');
    mysqli_query($conn, 'SET NAMES utf8');

    $userEmail = $_POST["userEmail"];
    $content = $_POST["content"];

    $statement = mysqli_prepare($conn, "SELECT content FROM todo WHERE userEmail = ?");

    mysqli_stmt_bind_param($statement, "ss", $content, $userEmail);
    mysqli_stmt_execute($statement);
    mysqli_stmt_store_result($statement);

    $response = array();
    $response["success"] = false;

    while(mysqli_stmt_fetch($statement)){
      $response["success"] = true;
      $response["userEmail"] = $userEmail;
    }

    echo json_encode($response);
?>