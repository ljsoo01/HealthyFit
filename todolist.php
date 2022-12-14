<?php
    error_reporting(E_ALL);
    ini_set('display_errors',1);
    
    include('dbconn.php');

    $android = strpos($_SERVER['HTTP_USER_AGENT'], "Android");

    if((($_SERVER['REQUEST_METHOD'] == 'POST') && isset($_POST['submit'])) || $android)
    {
        $userEmail = $_POST["userEmail"];
        $content = $_POST["content"];
        $date = $_POST["date"];

        if(!isset($errMSG)) {
            try {
                $stmt = $conn->prepare('INSERT INTO todo(userEmail, content, date) VALUES(:userEmail, :content, :date)');
                $stmt->bindParam(':userEmail', $userEmail);
                $stmt->bindParam(':content', $content);
                $stmt->bindParam(':date', $date);

                if($stmt->execute())
                {
                    $successMSG = "success";
                    $response = array();
                    $response["success"] = true;

                    echo json_encode($response);
                }
                else
                {
                    $errMSG = "fail";
                }
            } catch(PDOException $e) {
                die("Database error : ". $e->getMessage());
            }
        }
    }
?>

<?php
    if (isset($errMSG)) echo $errMSG;
    if (isset($successMSG)) echo $successMSG;
 
        $android = strpos($_SERVER['HTTP_USER_AGENT'], "Android");
 
    if( !$android )
    {
?>
    <html>
       <body>
            <form action="<?php $_PHP_SELF ?>" method="POST">
                userEmail: <input type = "text" name = "userEmail" />
                content: <input type = "text" name = "content" />
                date: <input type = "text" name = "date" />
                <input type = "submit" name = "submit" />
            </form>
 
       </body>
    </html>
<?php
    }
?>