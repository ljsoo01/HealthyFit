<?php
    $conn = mysqli_connect("127.0.0.1:3307", "root", "", "healthyfit");
    mysqli_query($conn, 'SET NAMES utf8');

    $userEmail = $_POST["userEmail"];
    $content = $_POST["content"];
    $date = $_POST["date"];

    $statement = mysqli_prepare($conn, "UPDATE todo SET content = ? WHERE userEmail = ? AND date = ?");
    mysqli_stmt_bind_param($statement, "sss", $content, $userEmail, $date);
    mysqli_stmt_execute($statement);

    mysqli_stmt_store_result($statement);

    $response = array();
    $response["success"] = true;

    echo json_encode($response);
?>