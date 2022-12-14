<?php
    $conn = mysqli_connect("127.0.0.1:3307", "root", "", "healthyfit");
    mysqli_query($conn, 'SET NAMES utf8');

    $userEmail = $_POST["userEmail"];
    $userPw = $_POST["userPw"];

    $statement = mysqli_prepare($conn, "DELETE FROM membertbl WHERE userEmail = ? AND userPw = ?");
    mysqli_stmt_bind_param($statement, "ss", $userEmail, $userPw);
    mysqli_stmt_execute($statement);

    $response = array();
    $response["success"] = true;

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