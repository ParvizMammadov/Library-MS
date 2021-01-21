
  <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #aa29f5; color: white;">
  	<a class="navbar-brand">Library Management System</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	</button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent" >
  
      <ul class="navbar-nav mr-auto" >
        
	    <li class="nav-item active">
	      <a class="nav-link" href="/books" style="margin-right: 600px;">Books </a>
	    </li>
        
        <li class="nav-item active">
          <a class="btn btn-danger" href="/logout" style="margin-right: 10px;">Logout </a>
        </li>
        
      </ul>
    
      <form action="/search-book" class="form-inline my-2 my-lg-0">
        <input class="form-control mr-sm-2" name= "keyword" type="text" placeholder="Search">
        <input class="btn btn-outline-success active my-2 my-sm-0" type="submit" value="Search" />
      </form>
    
    </div>
  </nav>
