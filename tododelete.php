<?php
    $conn = mysqli_connect("127.0.0.1:3307", "root", "", "healthyfit");
    mysqli_query($conn, 'SET NAMES utf8');

    $userEmail = $_POST["userEmail"];
    $date = $_POST["date"];

    $statement = mysqli_prepare($conn, "DELETE FROM todo WHERE userEmail = ? AND date = ?");
    mysqli_stmt_bind_param($statement, "ss", $userEmail, $date);
    mysqli_stmt_execute($statement);

    $response = array();
    $response["success"] = true;

    echo json_encode($response);
?>


<html>
   <body>
   
      <form action="<?php $_PHP_SELF ?>" method="POST">
         내용: <input type = "text" name = "content" />
         <input type = "submit" />
      </form>
   
   </body>
</html>
