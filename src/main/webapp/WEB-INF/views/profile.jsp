<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@taglib prefix="k" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="<k:url value='/r/css/profile.css'/>" />
<script src="<k:url value='/r/js/script.js'/>"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
	integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>Profile</title>
</head>
<body>
    <div class="container">
        <%@ include file="navbar.jsp"%>
        <section class="nav-categories">
            <div class="categories-container">
                <div class="profile-photo">
                    <img
                        src="https://images.unsplash.com/photo-1494790108377-be9c29b29330?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80" />
                    <!-- <img src="//images.unsplash.com/photo-1466112928291-0903b80a9466?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1173&q=80"/> -->
                </div>
                <div class="profile-content">
                    <div class="segment username">
                            @${user.getUsername() }
                        </div>
                        <div class="segment posts">
                            <span>${posts }</span><br>Posts
                        </div>
                        
                </div>
            </div>
        </section>
        <section class="main-section">
            <div class="main-container">
                <header>
                    <div class="title">Your Posts</div>
                    <div class="pagination">
						<k:if test="${currentPage >1 }">
							<div class="prev">
								<a
									href="profile?p=${currentPage-1}">PREV</a>
							</div>
						</k:if>
						<div class="number">
							<k:if test="${lastPage > 3 }">
								<k:if test="${currentPage == lastPage }">
									<a
										href="profile?p=${currentPage-3}">${currentPage - 3 }</a>
									<a
										href="profile?p=${currentPage-2}">${currentPage - 2 }</a>
									<a
										href="profile?p=${currentPage-1}">${currentPage - 1 }</a>
									<a class="active"
										href="profile?p=${currentPage}">${currentPage }</a>
								</k:if>
								<k:if test="${currentPage == 1 }">
									<a class="active"
										href="profile?p=${currentPage}">${currentPage }</a>
									<a
										href="profile?p=${currentPage+1}">${currentPage +1 }</a>
									<a
										href="profile?p=${currentPage+2}">${currentPage +2 }</a>
									<a
										href="profile?p=${currentPage+3}">${currentPage +3 }</a>
								</k:if>
								<k:if test="${currentPage == 2 }">
									<a
										href="profile?p=${currentPage-1}">${currentPage -1 }</a>
									<a class="active"
										href="profile?p=${currentPage}">${currentPage }</a>
									<a
										href="profile?p=${currentPage+1}">${currentPage +1 }</a>
									<a
										href="profile?p=${currentPage+2}">${currentPage +2 }</a>
								</k:if>
								<k:if test="${currentPage >2 && currentPage != lastPage }">
									<a
										href="profile?p=${currentPage-2}">${currentPage -2 }</a>
									<a
										href="profile?p=${currentPage-1}">${currentPage -1 }</a>
									<a class="active"
										href="profile?p=${currentPage}">${currentPage }</a>
									<a
										href="profile?p=${currentPage+1}">${currentPage +1 }</a>
								</k:if>
							</k:if>
							<k:if test="${lastPage <=3 }">
								<k:forEach begin="1" end="${lastPage }" var="i">
									<k:choose>
										<k:when test="${currentPage == i }">
											<a class="active"
												href="profile?p=${i}">${i}</a>
										</k:when>
										<k:otherwise>
											<a href="profile?p=${i}">${i}</a>
										</k:otherwise>
									</k:choose>
								</k:forEach>
							</k:if>
						</div>
						<k:if test="${currentPage != lastPage}">
							<div class="next">
								<a
									href="profile?p=${currentPage+1}">NEXT</a>
							</div>
						</k:if>
					</div>
                </header>
                <section class="main-container-captions">
                    <k:forEach var="c" items="${captions }">
						<div class="caption">
							<div class="content">
								<div class="caption-content">${c.getCaption() }</div>
							</div>
							<div class="user">
								<div class="detail">
									<span class="profile"> <img
										src="https://images.unsplash.com/photo-1441974231531-c6227db76b6e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1171&q=80" />
									</span> <span class="name"><a href="#">Username</a></span>
								</div>
								<div class="action">
									<div class="likes">
										<i class="fa-regular fa-heart"></i>
										<div class="like-number">${c.getLikes() }</div>
									</div>
									<div class="shares">
										<i class="fa-solid fa-share-nodes"></i>
										<div class="share-number">${c.getShares() }</div>
									</div>
								</div>
							</div>
						</div>
					</k:forEach>
                </section>
            </div>
        </section>
    </div>
</body>

</html>