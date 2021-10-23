static inventory
  ranges[START:END]
  server[01:100].example.com

dynamic inventory 

ansible --version
ansible-inventory -i inventory_SRV001.yml --list
ansible-config dump --only-changed
ansible-doc -l | grep ping
ansible-doc ping

# A-hoc command
ansible all -i inventory_SRV001.yml -m ping

ad-hoc commands
- can only call 1 module

ansible modules (idempotent)
- command (not idempotent)
- shell (not idempotent)
- ...

https://docs.ansible.com
> Module index


# playbooks

ansible-playbook -D site.yml --limit datacenter2


# Debugging playbooks
ansible-playbook --syntax-check site.yml
ansible-playbook --check site.yml  # dry run


# Variables
- precedence / scope


# Define variables in inventory
- host variables
- group variables


vars:
  username:
    test:
	  uname: test
	  description: Test user account
	
- dictionary (fetch a value from a dictionary username['test']['uname'])



vars:
  username:
  - aap
  - noot
  - mies
  
- list of values (loops over the elements)

- register statement


# Encryption
ansible-vault create secrets
ansible-vault view secrets
ansible-vault edit secrets
ansible-vault rekey secrets

ansible-playbook --vault-id vault_one@prompt --vault-id vault_two@prompt site.yml

ansible-vault encrypt filename --output=new_filename
ansible-vault decrypt filename


# Looping
- name: create users in their appropriate groups
  user:
    name: "{{ item.name }}"
    group: "{{ item.groups }}"
  with_dict:
    - { name: 'aap', groups: 'dieren' }
    - { name: 'noot', groups: 'vruchten' }
    - { name: 'mies', groups: 'mensen' }


# Handlers
- often used when you want to restart a service or a machine


# Blocks
- block (can have a when condition, same when applies to rescue and always blocks)
- rescue
- always


# Facts
ansible_facts is a dictionary
example: ansible_facts['all_ipv4_addresses']

# jinja2 templating
- filters

# lookup plugins
ansible-doc -t lookup -l
ansible-doc -t lookup fileglob


# Ansible lint
pip install ansible-lint