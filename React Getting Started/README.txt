React Getting Started

jscomplete.com/beginning-js
jscomplete.com/js-labs
jscomplete.com/react-cfp  # Commonly face problems
jscomplete.com/why-react
jscomplete.com/playground

jsdrops.com/rgs1.1  # React Getting Started


react devtools chrome extension

- components
input: props, state > output: UI
function component
class component


Array Functions

# https://reactjs.org/docs/hooks-reference.html
useState function


# CH2 The Basics

React is a library not a framework
Virtual DOM

- components (JSX)
  - function component
  - class component
  - the name of your component should always start with an uppercase letter
- reactive updates
- virtual views in memory

JSX > Babel is a JavaScript compiler

jsdrops.com/rgs1.2
jsdrops.com/rgs1.3
jsdrops.com/rgs1.4
jsdrops.com/rgs1.5
jsdrops.com/rgs1.6
jsdrops.com/rgs1.7
jsdrops.com/rgs1.8

(inline) arrow function definitions

useState hook (https://reactjs.org/docs/hooks-state.html)


parent components can flow their data / behaviour down to childrens components

where to define a state (in which component) > down in a tree as close as possible to children who need to access that value on the state




# CH3 Modern JavaScript crash course

https://jscomplete.com/learn/search/javascript


- Variables and block scopes
- Arrow functions
  - regular function > calling context
  - arrow function > defining context
- Object literals
- Destructing and Rest/Spread !!!
- Template Strings
- Classes
- Promises and Async/Await

jsdrops.com/scopes
jsdrops.com/const
jsdrops.com/why-const

jsdrops.com/arrow-vs-regular-functions

jsdrops.com/object-literals

jsdrops.com/destructuring
jsdrops.com/rest-spread

jsdrops.com/template-strings

jsdrops.com/classes

jsdrops.com/promises




# CH4 The GitHub Cards App

jsdrops.com/rgs2.1
jsdrops.com/rgs2.2
jsdrops.com/react-style
github.com/MicheleBertoli/css-in-js
jsdrops.com/rgs2.3 (api.github.com/users/gaearon) 
jsdrops.com/rgs2.4
jsdrops.com/rgs2.5
jsdrops.com/rgs2.6
jsdrops.com/rgs2.7

https://jscomplete.com/learn/react-beyond-basics

react components have a one flow of data
a component can not change the state of its parent



# CH6 Setting up a Development environment
npx create-react-app cra-test
npm run eject ???

Set up server side rendering (you can disable javascript on Chrome devtools and the code is still working)
https://jscomplete.com/reactful
https://github.com/jscomplete/rgs-template


# Create package.json
mkdir fulljs
cd fulljs
npm init -y

# Install express
npm i express

# Install react
npm i react react-dom

# Install webpack
npm i webpack webpack-cli

# Install babel
npm i babel-loader @babel/core @babel/node @babel/preset-env @babel/preset-react

# Install some development depedencies (-D stands for development)
npm i -D nodemon

# Install eslint
npm i -D eslint babel-eslint eslint-plugin-react eslint-plugin-react-hooks

# Create eslint config
touch .eslintrc.js

# Install prettier ???

# Install testing depedencies ???
npm i -D jest babel-jest react-test-renderer

# Create directory structure (used by webpack)
mkdir dist
mkdir src
mkdir src/components
mkdir src/server

# Create babel config file
touch babel.config.js

# Create config for webpack
touch webpack.config.js

# Update package.json
scripts: {
  "test": "jest"
  "dev:server": "nodemon --exec babel-node src/server/server.js --ignore dist/"
  "dev:bundler": "webpack -w --mode=development"
}

# Run the npm commands
npm run dev-server
npm run dev-bundle


#--------------

npx reactful star-match
https://github.com/jscomplete/rgs-star-match

Advanced React.js
GraphQL -> REST