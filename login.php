<?php
    $conn = mysqli_connect("127.0.0.1:3307", "root", "", "healthyfit");
    mysqli_query($conn, 'SET NAMES utf8');

    $userEmail = $_POST["userEmail"];
    $userPw = $_POST["userPw"];

    $statement = mysqli_prepare($conn, "SELECT userEmail, userPw, ifnull(userMemo, ''), ifnull(userDate, ''), ifnull(userHeight,''), ifnull(userWeight,''), ifnull(userBMI,''), ifnull(userETC,'') FROM membertbl WHERE userEmail = ? AND userPw = ?");
    mysqli_stmt_bind_param($statement, "ss", $userEmail, $userPw);
    mysqli_stmt_execute($statement);

    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $userEmail, $userPw, $userMemo, $userDate, $userHeight, $userWeight, $userBMI, $userETC);

    $response = array();
    $response["success"] = false;

    while(mysqli_stmt_fetch($statement)) {
        $response["success"] = true;
        $response["userEmail"] = $userEmail;
        $response["userPw"] = $userPw;
        $response["userMemo"] = $userMemo;
        $response["userDate"] = $userDate;
        $response["userHeight"] = $userHeight;
        $response["userWeight"] = $userWeight;
        $response["userBMI"] = $userBMI;
        $response["userETC"] = $userETC;
    }

    echo json_encode($response);
?>

<html>
   <body>
   
      <form action="<?php $_PHP_SELF ?>" method="POST">
         아이디: <input type = "text" name = "userEmail" />
         비밀번호: <input type = "text" name = "userPw" />
         <input type = "submit" />
      </form>
   
   </body>
</html>