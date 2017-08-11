class HelloController < ApplicationController
  def index
    render body: "Hello world!"
  end
end
