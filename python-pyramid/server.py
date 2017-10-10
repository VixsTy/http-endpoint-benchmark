#!/usr/bin/env python3

from wsgiref.simple_server import make_server
from pyramid.config import Configurator
from pyramid.response import Response


def hello_handler(req):
    return Response('Hello World!')

def build_app():
    with Configurator() as conf:
        conf.add_route('hello', '/')
        conf.add_view(hello_handler, route_name='hello')
        app = conf.make_wsgi_app()
        return app

if __name__ == '__main__':
    app = build_app()
    server = make_server('127.0.0.1', 3000, app)
    server.serve_forever()
