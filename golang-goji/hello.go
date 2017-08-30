package main

import (
	"fmt"
	"net/http"

	"goji.io"
	"goji.io/pat"
)

func hello(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, "Hello world !")
}

func main() {
	mux := goji.NewMux()
	mux.HandleFunc(pat.Get("/"), hello)

	http.ListenAndServe("localhost:8000", mux)
}
