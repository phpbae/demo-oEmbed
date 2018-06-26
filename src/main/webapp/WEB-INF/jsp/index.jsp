<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>oEmbed Test</title>

    <link rel="stylesheet" href="/webjars/bootstrap/4.1.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/index.css">
    <script src="/webjars/jquery/3.3.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <div id="header">
        <p>oEmbed Test(Youtube, vimeo)</p>
        <div>
            <div class="input-group mb-3">
                <input type="text" class="form-control" placeholder="URL Input..">
                <div class="input-group-append">
                    <button class="btn btn-outline-secondary" type="button" style="background-color: #e9ecef" id="oembed-submit">확 인</button>
                </div>
            </div>
            </form>
        </div>
    </div>
    <div id="contents">
        <table class="table table-hover table-dark" style="table-layout: fixed; word-wrap: break-word;">
            <tbody>

            </tbody>
        </table>
    </div>
</div>



</body>
</html>
<script src="/js/index.js"></script>

<script type="text/html" id="content-row">
    <tr>
        <td style="width: 20%">{{contents-name}}</td>
        <td style="width: 50%">
            {{contents-value}}
            {{thumbnail_url}}
        </td>
    </tr>
</script>