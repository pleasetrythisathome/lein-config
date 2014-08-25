{:user
 {:plugins [[lein-datomic "0.2.0"]

            ;; REPL
            [cider/cider-nrepl "0.8.0-SNAPSHOT"]
            [lein-pprint "1.1.1"]

            ;; Automated testing
            [lein-cloverage "1.0.2"]
            [lein-test-out "0.3.1"]
            [lein-midje "3.1.3"]

            ;; Package management
            [lein-ancient "0.5.5"]
            [lein-deps-tree "0.1.2"]
            [lein-localrepo "0.5.3"]
            [lein-plz "0.1.1"]
            [lein-templater "0.1.1-SNAPSHOT"]

            ;; Documentation
            [codox "0.8.10"]
            [lein-clojuredocs "1.0.2"]

            ;; Static analysis
            [lein-typed "0.3.5"]
            [jonase/eastwood "0.1.4"]
            [lein-bikeshed "0.1.7"]
            [lein-kibit "0.0.8"]

            ;; Templates
            [immutable-stack/lein-template "0.1.0-SNAPSHOT"]
            [mies-om-weasel/lein-template "0.1.0-SNAPSHOT"]
            [satori/lein-template "0.1.0-SNAPSHOT"]]

  :plz ["/Users/HereNow/.lein/plz/mappings.edn"]

  :dependencies [[org.clojars.gjahad/debug-repl "0.3.3"]
                 [difform "1.1.2"]

                 [spyscope "0.1.4"]
                 [org.clojure/tools.trace "0.7.8"]

                 [leiningen #=(leiningen.core.main/leiningen-version)]
                 [im.chit/iroh "0.1.11"]
                 [io.aviso/pretty "0.1.8"]

                 [org.clojure/tools.namespace "0.2.4"]
                 [im.chit/vinyasa "0.2.2"]

                 [criterium "0.4.3"]]

  :injections [(require 'alex-and-georges.debug-repl)
               (require 'com.georgejahad.difform)
               (require 'spyscope.core)
               (require '[vinyasa.inject :as inject])
               (require 'io.aviso.repl)
               (inject/in ;; the default injected namespace is `.`

                ;; note that `:refer, :all and :exclude can be used
                [vinyasa.inject :refer [inject [in inject-in]]]
                [vinyasa.lein :exclude [*project*]]

                ;; imports all functions in vinyasa.pull
                [vinyasa.pull :all]

                ;; same as [cemerick.pomegranate
                ;;           :refer [add-classpath get-classpath resources]]
                [cemerick.pomegranate add-classpath get-classpath resources]

                ;; inject into clojure.core
                clojure.core
                [iroh.core .> .? .* .% .%>]

                ;; inject into clojure.core with prefix
                clojure.core >
                [clojure.pprint pprint pp]
                [clojure.java.shell sh]

                clojure.core >
                [clojure.repl apropos dir doc find-doc pst source]
                [clojure.tools.trace trace trace-forms trace-ns trace-vars
                 untrace-ns untrace-vars]
                [clojure.test run-tests run-all-tests]
                [com.georgejahad.difform difform]
                [alex-and-georges.debug-repl debug-repl])]}}
