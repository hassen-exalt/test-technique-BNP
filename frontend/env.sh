#!/bin/sh

# Script pour créer le fichier env-config.js au démarrage
cat <<EOF > /usr/share/nginx/html/env-config.js
window._env_ = {
  REACT_APP_BACKEND_URL: "$REACT_APP_BACKEND_URL",
};
EOF

# Exécuter Nginx
exec "$@"
