<html>
  <head>
    <title>SiteMesh Example: <sitemesh:write property="title">Title goes here</sitemesh:write></title>
    <style>
      body { font-family: arial, sans-serif; background-color: #ffffcc; }
      h1, h2, h3, h4 { text-align: center; background-color: #ccffcc; border-top: 1px solid #66ff66; }
      .disclaimer { text-align: center; border-top: 1px solid #cccccc; margin-top: 40px; color: #666666; font-size: smaller; }
    </style>
    <sitemesh:write property="head"/>
  </head>
  <body>

    <h1 class="title"><a href="/" style="float:left;"><img height="40" src="/assets/logo.png" /></a>SiteMesh Example Site: <sitemesh:write property="title">Title goes here</sitemesh:write></h1>

    <sitemesh:write property="body">Body goes here. Blah blah blah.</sitemesh:write>

    <div class="disclaimer">Site disclaimer. This is an example.</div>
    <div class="navigation">
      <b>Examples:</b>
      [<a href="/">GSP example</a>]
      [<a href="/greeting404">404 example</a>]
    </div>

  </body>
</html>