<?php
    $conn = mysqli_connect('127.0.0.1:3307', 'root', '', 'healthyfit');

    $userEmail = $_POST["userEmail"];

    $statement = mysqli_prepare($conn, "SELECT userEmail FROM membertbl WHERE userEmail = ?");

    mysqli_stmt_bind_param($statement, "s", $userEmail);
    mysqli_stmt_execute($statement);
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $userID);

    $response = array();
    $response["success"] = true;

    while(mysqli_stmt_fetch($statement)){
      $response["success"] = false;
      $response["userEmail"] = $userEmail;
    }

    echo json_encode($response);
?>