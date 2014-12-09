(ns macrobook.cont)

(use 'delimc.core)

(defn my-multiply [param1 param2]
  (reset
    (shift k
             (if (or (string? param1) (string? param2))
               (println "works only on numbers")
               (k :ok)))
    (println "multiplying...")
    (* param1 param2)))


(my-multiply 4 5)

(my-multiply 4 "5")
