(ns macrobook.core
  (:require [clojure.pprint :as pp]))

(defrecord RemoteMapper [content])

(defmacro defmapper
  "runs the function f over the content

  f is a function of two arguments, key and value.

  f must return a sequence of *pairs* like
   [[key1 value1] [key2 value2] ...]
  "
  [fname args & body]
  `(let [instance# (RemoteMapper.
                     (pr-str '(fn ~args ~@body)))]
     (def ~fname instance#)))

(defmapper mapper1 [x] (* x 2))

mapper1

(gensym "xyz")

(defmacro info-about-caller []
  (pp/pprint {:form &form :env &env})
  `(println "macro was called!"))

(info-about-caller)

(let [x 5] (info-about-caller))


(defmacro inspect-caller-locals [] (->> (keys &env)
                                        (map (fn [k] [`'~k k])) (into {})))

(let [x 5 y 6] (inspect-caller-locals))





