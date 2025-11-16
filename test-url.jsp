<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Test de Mapping d'URLs</title>
    <style>
        body { font-family: Arial, sans-serif; max-width: 800px; margin: 50px auto; padding: 20px; background-color: #f5f5f5; }
        .container { background: #fff; padding: 30px; border-radius: 8px; box-shadow: 0 2px 8px rgba(0,0,0,0.08); }
        h1 { color: #333; border-bottom: 2px solid #4CAF50; padding-bottom: 10px; }
        .form-group { margin: 20px 0; }
        label { display: block; margin-bottom: 6px; font-weight: 600; color: #444; }
        input[type="text"] { width: 100%; padding: 10px; border: 1px solid #ddd; border-radius: 4px; font-size: 16px; }
        button { background: #4CAF50; color: #fff; padding: 10px 24px; border: 0; border-radius: 4px; cursor: pointer; font-size: 16px; }
        button:hover { background: #43a047; }
        .result { margin-top: 24px; padding: 16px; border-radius: 4px; }
        .success { background: #e8f5e9; border: 1px solid #c8e6c9; color: #2e7d32; }
        .error { background: #ffebee; border: 1px solid #ffcdd2; color: #c62828; }
        .url-list { margin-top: 20px; }
        .url-item { padding: 8px; margin: 6px 0; background: #fafafa; border-left: 3px solid #4CAF50; cursor: pointer; }
        .url-item:hover { background: #f1f8e9; }
    </style>
</head>
<body>
<div class="container">
    <h1>🔍 Test de Mapping d'URLs</h1>
    <div class="info">
        <strong>Instructions:</strong> Entrez une URL pour rechercher le contrôleur et la méthode correspondants.
    </div>

    <form action="testUrl" method="post">
        <div class="form-group">
            <label for="url">URL à rechercher:</label>
            <input type="text" id="url" name="url" placeholder="/admin/settings" value="<%= request.getParameter("url") != null ? request.getParameter("url") : "" %>" required>
        </div>
        <button type="submit">Rechercher</button>
    </form>

    <%
        String result = (String) request.getAttribute("result");
        String className = (String) request.getAttribute("className");
        String methodName = (String) request.getAttribute("methodName");
        String searchUrl = (String) request.getAttribute("searchUrl");
        Boolean found = (Boolean) request.getAttribute("found");
        if (result != null) {
    %>
    <div class="result <%= (found != null && found) ? "success" : "error" %>">
        <h3><%= (found != null && found) ? "✅ URL Trouvée" : "❌ 404 - URL Non Trouvée" %></h3>
        <p><strong>URL recherchée:</strong> <%= searchUrl %></p>
        <% if (found != null && found) { %>
            <p><strong>Classe:</strong> <%= className %></p>
            <p><strong>Méthode:</strong> <%= methodName %></p>
        <% } else { %>
            <p>Aucun mapping trouvé pour cette URL.</p>
        <% } %>
    </div>
    <% } %>

    <div class="url-list">
        <h3>URLs de test disponibles:</h3>
        <div class="url-item" onclick="document.getElementById('url').value='/test';">/test</div>
        <div class="url-item" onclick="document.getElementById('url').value='/hello';">/hello</div>
        <div class="url-item" onclick="document.getElementById('url').value='/simple';">/simple</div>
        <div class="url-item" onclick="document.getElementById('url').value='/another';">/another</div>
        <div class="url-item" onclick="document.getElementById('url').value='/admin/dashboard';">/admin/dashboard</div>
        <div class="url-item" onclick="document.getElementById('url').value='/admin/settings';">/admin/settings</div>
    </div>
</div>
</body>
</html>
