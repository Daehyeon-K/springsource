<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../includes/header.jsp" %>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board Read</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>            
            <div class="row">
                <div class="col-lg-12">
                	<div class="panel panel-default">
                        <div class="panel-heading">
                           Board Read Page
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                			<form action="" role="form">
                				<div class="form-group">
                					<label>Bno</label>
                					<input class="form-control" name="bno" readonly="readonly" value="${dto.bno}">                				
                				</div> 
                				<div class="form-group">
                					<label>Title</label>
                					<input class="form-control" name="title" readonly="readonly" value="${dto.title}">                				
                				</div>  
                				<div class="form-group">
                					<label>Content</label>
                					<textarea class="form-control" rows="3" name="content" readonly="readonly" >${dto.content}</textarea>               				
                				</div> 
                				<div class="form-group">
                					<label>Writer</label>
                					<input class="form-control" name="writer" readonly="readonly" value="${dto.writer}">                				
                				</div>  
                				<button type="button" class="btn btn-default">Modify</button>     			
                				<button type="reset" class="btn btn-info">List</button>          			
                			</form>
                		</div>
                	</div>
                </div>
            </div>   

<%-- ?????? ?????? ?????? --%>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading"><i class="fa fas fa-file"></i> ????????????</div>
			<div class="panel-body">
				<div class="uploadResult">
					<ul><!-- ???????????? ?????? --></ul>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="bigPictureWrapper">
	<div class="bigPicture"></div>
</div>

<%-- ?????? ????????? ?????? --%>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<i class="fa fa-comments fa-fw"></i>
				Reply
				<button id="addReplyBtn" class="btn btn-primary btn-xs pull-right">New Reply</button>
			</div>
			<div class="panel-body">
				<ul class="chat">
					<li class="left clearfix" data-rno="12">
						<div>
							<div class="header">
								<strong class="primary-font">user00</strong>
								<small class="pull-right text-muted">2022-05-04 15:54</small>
							</div>
							<!-- ?????? ?????? -->
							<p>Good Job!!!!</p>
						</div>
					</li>
				</ul>
			</div>
			<%-- ?????? ????????? ?????? --%>
			<div class="panel-footer"></div>
		</div>
	</div>
</div>

<!-- ?????? ?????? ?????? ??? -->
<div class="modal" tabindex="-1" id="replyModal" data-rno="1">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <h5 class="modal-title">Reply</h5>
      </div>
      <div class="modal-body">
        <div class="form-group">
			<label for="">??????</label>
			<input type="text" name="reply" id="" class="form-control" placeholder="?????? ??????"/>        
        </div>
        <div class="form-group">
			<label for="">?????????</label>
			<input type="text" name="replyer" id="" class="form-control" placeholder="?????????"/>        
        </div>
        <div class="form-group">
			<label for="">?????????</label>
			<input type="text" name="replydate" id="" class="form-control" placeholder="?????????"/>        
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-warning" id="modalRegisterBtn">??????</button>
        <button type="button" class="btn btn-success" id="modalModBtn">??????</button>
        <button type="button" class="btn btn-danger" id="modalRemoveBtn">??????</button>
        <button type="button" class="btn btn-primary" id="modalCloseBtn" data-dismiss="modal">??????</button>
      </div>
    </div>
  </div>
</div>
                    
<%--modify ?????? ?????? ??? ????????? ??? --%>
<form action="/board/modify" id="operForm">
	<input type="hidden" value="${dto.bno}" name="bno" />
	<input type="hidden" value="${cri.pageNum}" name="pageNum" />
	<input type="hidden" value="${cri.amount}" name="amount" />
	<input type="hidden" value="${cri.type}" name="type" />
	<input type="hidden" value="${cri.keyword}" name="keyword" />
</form>
<script>
	// ?????? ??? ??????
	let bno = ${dto.bno};
</script>

<script src="/resources/js/read.js?ver=1"></script>
<script src="/resources/js/reply.js?ver=3"></script>
<script src="/resources/js/upload.js?ver=1"></script>

<%@include file="../includes/footer.jsp" %>       