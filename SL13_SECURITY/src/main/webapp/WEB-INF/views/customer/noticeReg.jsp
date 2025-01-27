<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<div id="content">
   <h2>공지사항</h2>
   <h3 class="hidden">방문페이지위치</h3>
   <ul id="breadscrumb" class="block_hlist">
      <li>HOME</li>
      <li>고객센터</li>
      <li>공지사항수정</li>
   </ul>
<!--    스프링 시큐리티와 
   enctype="multipart/form-data"을 설정한 경우
   토큰 처리 방법이 다르다. -->
   <!-- <form action="" method="post" enctype="multipart/form-data"> -->
   <form action="/customer/noticeReg.htm?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
      <div id="notice-article-detail" class="article-detail margin-large">
         <dl class="article-detail-row">
            <dt class="article-detail-title">제목</dt>
            <dd class="article-detail-data">
               &nbsp;<input name="title" value="${notice.title }" />
            </dd>
         </dl>
         <dl class="article-detail-row half-row">
            <dt class="article-detail-title">작성자</dt>
            <dd class="article-detail-data half-data">${notice.writer }</dd>
         </dl>
         <dl class="article-detail-row half-row">
            <dt class="article-detail-title">조회수</dt>
            <dd class="article-detail-data half-data">${notice.hit }</dd>
         </dl>
         <dl class="article-detail-row">
            <dt class="article-detail-title">첨부파일</dt>
            <dd class="article-detail-data">
               &nbsp;<input type="file" id="txtFile" name="file" />
               <!-- 해당 공지사항 글의 첨부파일을 출력 -->
               <input type="text" name="o_filesrc" value="${notice.filesrc }" />
            </dd>
         </dl>

         <div class="article-content">
            <textarea id="txtContent" class="txtContent" name="content">${notice.content }</textarea>
         </div>
      </div>
      <p class="article-comment margin-small">
         <!-- <a class="btn-save button" href="noticeEditProc.jsp">수정</a> -->
         <button class="btn-save-button" type="submit">수정</button>
         <a class="btn-cancel button"
            href="notice.htm">취소</a>
      </p>
<%--       <input type="hidden" name="${_csrf.parameterName }"
         value="${_csrf.token }" /> --%>
   </form>
</div>