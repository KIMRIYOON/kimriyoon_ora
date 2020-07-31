<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="../include/header.jsp" %>


	<!-- //container -->
	<div id="container">
	<%@ include file="../include/container_header.jsp" %>
		<!-- bodytext_area -->
		<div class="bodytext_area box_inner">	
			<ul class="bbsview_list">
				<li class="bbs_title">${boardVO.title}</li>
				<li class="bbs_title">
					<select title = "게시판을 선택하세요" required class="select_common">
                      <option value="notice" <c:out value="${(boardVO.bod_type eq 'notice')?('selected'):('')}" />>공지사항</option>
                      <option value="gallery" <c:out value="${(boardVO.bod_type eq 'gallery')?('selected'):('')}" />>갤러리</option> 
       				</select>
				</li>
				<li class="bbs_hit">작성일 : <span><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVO.regdate}"/></span></li>
				<li class="bbs_date">조회수 : <span>${boardVO.view_count}</span></li>
				<li class="bbs_content">
					<div class="editer_content">
					<textarea style="width:100%;min-height:200px;">${boardVO.content}</textarea>
                    </div>
				</li>
				<c:if test="${boardVO.files[0] != null}">
					<li class="bbs_content">
					<a href="/download?filename=${boardVO.files[0]}">${boardVO.files[0]} 다운로드</a>
					<br>
					<c:set var="extName" value="${fn:split(boardVO.files[0],'.')}" />
					<c:set var="ext" value="${extName[fn:length(extName)-1]}" />
					<c:if test="${fn:containsIgnoreCase(extNameArray, ext)}">
						<img src="/download?filename=${boardVO.files[0]}" title="첨부파일 이미지" style="width:100%;">
					</c:if>
					</li>
				</c:if>
			</ul>
			<p class="btn_line txt_right">
			<c:if test="${session_enabled}">
				<a href="javascript:;" id="deleteBno" class="btn_bbs">삭제</a>
				<a href="/board/update?page=${pageVO.page}&bno=${boardVO.bno}" class="btn_bbs">수정</a>
			</c:if>
				<a href="/board/list?page=${pageVO.page}" class="btn_bbs">목록</a>
			</p>
		</div>
		<!-- //bodytext_area -->

	</div>
	<!-- //container -->
	<form id="deleteForm">
		<input name="bno" id="bno" type="hidden" value="${boardVO.bno}">
	</form>
	<script>
	$(document).ready(function(){
		$("#deleteBno").bind("click",function(){
			if(confirm("삭제하시겠습니까?")) {
				var formObj = $("#deleteForm");
				formObj.attr("action","/board/delete");
				formObj.attr("method", "post");
				//alert($("#bno").val());//디버그용
				formObj.submit();
			}else{
				return false;
			}
		})
	});
	</script>
<%@ include file="../include/footer.jsp" %>