## 개발 시 주의사항

- 기본 탬플릿은 index.html입니다.
```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head th:replace="fragments/header :: header"></head>

<body class="sb-nav-fixed">
<nav th:replace="fragments/nav :: nav"></nav>
<div th:replace="fragments/sidenav :: sidenav"></div> 

 <!-- 여기에 html tag를 사용하여 개발하면 됩니다.  -->
        
<div th:fragment="fragments/footer :: footer"></div>
<th:block th:include="fragments/config :: config"></th:block>

<script>

// 자바스크립트는 script tag를 열어서 사용하면 됩니다.

</script>

</body>
</html>
```
<br>



## 실행 시 주의사항
- Home(localhost:8080)은 index.html입니다. 필요하시면 수정하시면 됩니다.
- java email 기능을 넣을시에는 application.xml 을 gitignore에 추가해주세요.
