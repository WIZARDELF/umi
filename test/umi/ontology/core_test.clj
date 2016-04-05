(ns umi.ontology.core-test
  (:require [umi.ontology.core :as ontology]
            [umi.ontology.util :as util]
            [clojure.test :refer :all]))

(def pizza-uri "http://protege.stanford.edu/ontologies/pizza/pizza.owl")
(def pizza-ontology (ontology/load-ontology-from-uri pizza-uri))
(def class-americanhot-uri "http://www.co-ode.org/ontologies/pizza/pizza.owl#AmericanHot")
(def class-americanhot (util/uri->class-exp class-americanhot-uri))
(def class-americanhot-id "http://www.co-ode.org/ontologies/pizza/pizza.owl#AmericanHot")

(deftest load-ontology-from-uri-test
  (is (= 940
         (.getAxiomCount (ontology/load-ontology-from-uri pizza-uri))))
  (is (= 712
       (.getLogicalAxiomCount (ontology/load-ontology-from-uri pizza-uri)))))

(deftest get-all-axiom-test
  (is (= 940
         (count (ontology/get-all-axiom pizza-ontology)))))
