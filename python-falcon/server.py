#!/usr/bin/env python3

import falcon
import json
from wsgiref.simple_server import make_server

class HelloWorld(object):

    def on_get(self, req, resp):
        resp.body = 'Hello World!'

def build_app():
    app = falcon.API()
    app.add_route("/", HelloWorld())
    return app

if __name__ == '__main__':
    app = build_app()
    server = make_server('127.0.0.1', 3000, app)
    server.serve_forever()
